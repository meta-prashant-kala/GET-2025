import { createSlice } from '@reduxjs/toolkit';
import { v4 as uuidv4 } from 'uuid';

const TaskSlice=createSlice({
    name:"TaskSlice",
    initialState: () => {
      const newData = localStorage.getItem("taskList");
      if (newData !== null && newData.length > 0) return JSON.parse(newData)
      else return []
    },
    reducers: {
      addTask:(state, action)=>{
      action.payload.creationDate = new Date().toISOString().split('T')[0]
      action.payload.id = uuidv4();

      state.push(action.payload)
      },
      editTask:(state,action)=>{
        const task = state.find((t) => t.id === action.payload.id)
        task.title = action.payload.title;
        task.description = action.payload.description;
        task.priority = action.payload.priority;
        task.status = action.payload.status;
        task.completionDate = action.payload.completionDate
      },
      deleteTask:(state,action)=>{
        return state.filter((task) => task.id !== action.payload);
      }
    }
})

export const {addTask,editTask,deleteTask} = TaskSlice.actions

export default TaskSlice.reducer;

