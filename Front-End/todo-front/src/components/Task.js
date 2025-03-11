import React from 'react';

const todoTask = ({ task }) => {
  return (
    <div className ="task-card">
        <h2>{task.title}</h2>
        <p>{task.description}</p>
        <p><strong>Created At:</strong> {new Date(task.createdAt).toLocaleString()}</p>
        <p><strong>Due Date:</strong>{task.due ? new Date(task.due).toLocaleString() : "No due date"}</p>
        <p><strong>Status:</strong>{task.done ? "Completed ✅" : "Pending ❌"}</p> 
    </div>
    );
};

export default todoTask;