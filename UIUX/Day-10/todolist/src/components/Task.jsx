import {React, useEffect, useRef} from 'react'
import { Card, Row, Col, Button } from 'react-bootstrap'

const Task = ({ currentTask,handleDeleteTask, handleEditTask }) => {
  const bgColor=useRef(0);

  useEffect(()=>{
    switch(currentTask.priority){
      case "Low":
        bgColor.current.style.backgroundColor="rgb(107, 107, 252)";
        break;
      case "Medium":
        bgColor.current.style.backgroundColor="rgb(225, 168, 83)";
        break;
      case "High":
        bgColor.current.style.backgroundColor="rgb(248, 77, 77)";
        break;
    }
  })
  
  return (
    <Card className='px-2 text-light' ref={bgColor}>
      <Row>
        <Col className='text-start px-4'><h5>{currentTask.title}</h5></Col>
        <Col className='d-flex justify-content-end gap-3'>
          {
            currentTask.status!=='completeTask'?<div role="button" onClick={()=>{handleEditTask(currentTask.id, currentTask)}}>
            <i className="bi bi-pencil"></i>
            </div>:<></>
          }
          <div role="button"  onClick={()=>handleDeleteTask(currentTask.id, currentTask.status)}>
          <i className="bi bi-x-lg"></i>
          </div>
        </Col>
      </Row>
      <p className='m-0 text-start px-2'>{currentTask.description}</p>
    </Card>
  )
}

export default Task