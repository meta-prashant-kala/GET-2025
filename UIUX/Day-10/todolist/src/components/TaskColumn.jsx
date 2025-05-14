import React from 'react'

import {Col } from "react-bootstrap";
import Task from "./Task";

const TaskColumn = ({taskStatus, taskList, handleDeleteTask, handleEditTask}) => {
    return (
        <Col >
            <div className="board-color rounded">
                <p className="fw-bold m-0 p-2 ">{taskStatus}</p>
                <div className="board-content-color d-flex flex-column p-2 gap-2">
                    {
                        taskList.map((currentTask) => <Task key={currentTask.id} handleDeleteTask={handleDeleteTask} currentTask={currentTask} handleEditTask={handleEditTask} />)
                    }
                </div>
            </div>
        </Col>
    )
}

export default TaskColumn