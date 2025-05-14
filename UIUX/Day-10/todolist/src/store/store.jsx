import { configureStore } from '@reduxjs/toolkit';
import TaskSliceReducer from '../taskslice/TaskSlice'


const store = configureStore({
    reducer: {
        tasks: TaskSliceReducer
    }
})

export default store;