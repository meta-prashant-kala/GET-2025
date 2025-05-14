import { useEffect, useMemo, useState } from 'react'
import './App.css'
import Navbar from './components/Navbar'
import TaskCreateModal from './components/TaskCreateModal'
import Tasks from './components/Tasks';
import { ToastContainer, toast } from 'react-toastify';
import { v4 as uuidv4 } from 'uuid';
import { useDispatch, useSelector } from 'react-redux';
import { addTask, deleteTask, editTask } from './taskslice/TaskSlice';

function App() {

  const dispatch=useDispatch();

  const [show, setShow] = useState(false);

  const [clickType, setClickType] = useState("new-task");

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  const handleEditTask = (id, currentTask) => {
    setTaskDetails(currentTask);
    setClickType("edit-task");
    handleShow();
  }

  const handleDeleteTask = (id) => {
    dispatch(deleteTask(id))
  };

  const handleInputChange = (event) => {
    const name = event.target.name;
    const value = event.target.value;
    setTaskDetails((prev) => ({ ...prev, [name]: value }));
  }

  const [taskDetails, setTaskDetails] = useState({
    id: "",
    title: "",
    description: "",
    status: "newTask",
    creationDate: "",
    completionDate: "",
    priority: "Low"
  })

  const taskList = useSelector((state) => state.tasks)

  useEffect(() => {
    localStorage.setItem("taskList", JSON.stringify(taskList))
  }, [taskList])


  const groupedTasks = useMemo(() => {
    return {
      newTask: taskList.filter((t) => t.status === 'newTask'),
      inProgressTask: taskList.filter((t) => t.status === 'inProgressTask'),
      completeTask: taskList.filter((t) => t.status === 'completeTask'),
    }
  }, [taskList])


  const handleCreateTask = () => {
    if (taskDetails.title.length === 0 || taskDetails.priority.length === 0 || taskDetails.completionDate.length === 0) {
      toast("Please fill all the task fields");
      return;
    }
    if (clickType === 'new-task') {
      console.log(taskDetails);
      dispatch(addTask(taskDetails));
    }
    
    if (clickType === 'edit-task') {
      dispatch(editTask(taskDetails));

    }

    handleClose();
    setTaskDetails({
      id: '',
      title: "",
      description: "",
      status: "newTask",
      creationDate: "",
      completionDate: "",
      priority: "Low"
    })
    setClickType("new-task");
  }


  return (
    <>
      <div className='container'>
        <TaskCreateModal show={show} handleClose={handleClose} handleCreateTask={handleCreateTask} handleInputChange={handleInputChange} taskDetails={taskDetails} clickType={clickType} setClickType={setClickType} setTaskDetails={setTaskDetails} />
        <Navbar handleShow={handleShow} />
        <hr className='w-100 m-0 p-0 pb-2'/>
        <Tasks newTaskList={groupedTasks.newTask} inProgressTaskList={groupedTasks.inProgressTask} completedTaskList={groupedTasks.completeTask} handleDeleteTask={handleDeleteTask} handleEditTask={handleEditTask} />
        <ToastContainer />
      </div>
    </>
  )
}

export default App
