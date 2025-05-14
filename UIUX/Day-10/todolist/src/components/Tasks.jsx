import React from "react";
import { Container, Row } from "react-bootstrap";
import TaskColumn from "./TaskColumn";

const Tasks = ({ newTaskList, inProgressTaskList, completedTaskList, handleDeleteTask, handleEditTask }) => {

    return (
        <Container>
            <Row className="text-center">
                <TaskColumn  handleDeleteTask={handleDeleteTask} handleEditTask={handleEditTask}  taskStatus="New" taskList={newTaskList}/>
                <TaskColumn  handleDeleteTask={handleDeleteTask} handleEditTask={handleEditTask}  taskStatus="In Progress" taskList={inProgressTaskList}/>
                <TaskColumn  handleDeleteTask={handleDeleteTask} handleEditTask={handleEditTask}  taskStatus="Completed" taskList={completedTaskList}/>
            </Row>
        </Container>
    )
}

export default Tasks;