import React, { useState, useEffect } from "react";
import TodoTask from "./components/Task.js";

const API_URL = "http://localhost:8080/api/todos";

function App() {
    const [tasks, setTasks] = useState([])
    const [loading,setLoading] = useState(true)

    useEffect(() => {
        const fetchTasks = async () => {
            try {
                const response = await fetch(API_URL);
                if(!response.ok) {
                    throw new Error("Fetching Failed!");
                }
                const data = await response.json();
                setTasks(data);
            } catch (error) {
                console.error("Error fetching tasks: ", error);
            } finally {
                setLoading(false);
            }
        };

        fetchTasks();
    }, []);

    return (
        <div className="App">
          <h1>Todo List</h1>
          {loading ? (
            <p>Loading tasks...</p>
          ) : tasks.length > 0 ? (
            tasks.map((task) => <TodoTask key={task.id} task={task} />)
          ) : (
            <p>No tasks found</p>
          )}
        </div>
      );
    }

  export default App;