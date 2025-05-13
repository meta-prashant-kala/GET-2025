import React from "react";
import { Container, Row, Col, Card } from "react-bootstrap";
import Task from "./Task";
const Tasks = ({ newTaskList, inProgressTaskList, completedTaskList, handleDeleteTask, handleEditTask }) => {

    return (
        <Container>
            <Row className="text-center">
                <Col >
                    <div className="board-color rounded">
                        <p className="fw-bold m-0 p-2 ">New</p>
                        <div className="board-content-color d-flex flex-column p-2 gap-2">
                            {
                                newTaskList.map((currentTask) => <Task key={currentTask.id} handleDeleteTask={handleDeleteTask} currentTask={currentTask} handleEditTask={handleEditTask} />)
                            }
                        </div>
                    </div>
                </Col>
                <Col>
                    <div className="board-color">
                    <p className="fw-bold m-0 p-2 ">In Progress</p>
                        <div className="board-content-color d-flex flex-column p-2 gap-2">
                            {
                                inProgressTaskList.map((currentTask) => <Task key={currentTask.id} handleDeleteTask={handleDeleteTask} currentTask={currentTask} handleEditTask={handleEditTask} />)
                            }
                        </div>
                    </div>
                </Col>
                <Col>
                    <div className="board-color">
                    <p className="fw-bold m-0 p-2 ">Completed</p>
                        <div className="board-content-color d-flex flex-column p-2 gap-2">
                            {
                                completedTaskList.map((currentTask) => <Task key={currentTask.id} handleDeleteTask={handleDeleteTask} currentTask={currentTask} handleEditTask={handleEditTask} />)
                            }
                        </div>
                    </div>
                </Col>
            </Row>
        </Container>
    )
}

export default Tasks;