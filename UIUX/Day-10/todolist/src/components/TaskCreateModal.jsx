import { useState } from 'react';
import React from 'react';
import { Modal, Form, Button } from 'react-bootstrap';

function TaskCreateModal({ show, handleClose, handleCreateTask, handleInputChange, taskDetails, clickType, setClickType, setTaskDetails}) {

    return (
        <>
            <Modal show={show} onHide={handleClose}>
                <Modal.Header>
                    <Modal.Title>Modal heading</Modal.Title>
                    <Button variant="secondary" onClick={()=>{
                        handleClose();
                        setClickType("new-task");
                        setTaskDetails({
                            title: "",
                            description: "",
                            status: "newTask",
                            creationDate: "",
                            completionDate: "",
                            priority: "Low"
                          })
                    }}>
                        X
                    </Button>
                </Modal.Header>
                <Modal.Body>
                    <Form>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label>Title</Form.Label>
                            <Form.Control
                                type="text"
                                value={taskDetails.title}
                                onChange={handleInputChange}
                                name="title"
                                autoFocus
                                required
                            />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                            <Form.Label>Description</Form.Label>
                            <Form.Control
                                onChange={handleInputChange}
                                value={taskDetails.description}
                                name="description"
                                as="textarea" rows={3} />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label>Status</Form.Label>
                            <Form.Select
                                value={taskDetails.status}
                                onChange={handleInputChange}
                                name="status"
                                required
                            >
                                <option value="newTask">New</option>
                                {clickType!=='new-task'?
                                <>
                                <option value="inProgressTask">In Progress</option>
                                <option value="completeTask">Complete</option>
                                </>:
                                <>
                                </>
                                }
                            </Form.Select>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label>Creation Date </Form.Label>
                            <Form.Control
                                type="date"
                                value={clickType === 'new-task' ? (new Date().toISOString().split('T')[0]) : (taskDetails.creationDate)}
                                onChange={handleInputChange}
                                name="creationDate"
                                disabled
                            />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label>Completion Date </Form.Label>
                            <Form.Control
                                type="date"
                                value={taskDetails.completionDate}
                                onChange={handleInputChange}
                                name="completionDate"
                                required
                            />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label>Priority</Form.Label>
                            <Form.Select
                                name="priority"
                                value={taskDetails.priority}
                                onChange={handleInputChange}
                                required
                            >
                                <option value="Low">Low</option>
                                <option value="Medium">Medium</option>
                                <option value="High">High</option>

                            </Form.Select>
                        </Form.Group>

                    </Form>
                </Modal.Body>
                <Modal.Footer className='d-flex justify-content-between'>
                    <p></p>
                    <Button variant="primary" onClick={handleCreateTask}>
                        {clickType ==='new-task' ?"Create Task":"Save Changes"}
                    </Button>
                </Modal.Footer>
            </Modal>
        </>
    );
}

export default TaskCreateModal;