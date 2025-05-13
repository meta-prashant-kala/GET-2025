import React from "react";

const Navbar=({handleShow})=>{
    return(
        <div className="d-flex justify-content-between p-2">
            <h3 className="my-auto fw-bold">My Task Tracker</h3>
            <button variant="primary" className="btn btn-secondary" onClick={handleShow}>New Task</button>

        </div>
    )
}

export default Navbar;