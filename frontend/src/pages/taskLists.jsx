import React, { useState, useEffect } from 'react';
import { tasklistService } from '../services/api';

const TaskLists = () => {
  const[taskLists, setTasksLists] = useState([]);
  useEffect(() => {
    const fetchTaskLists = async () => {
      try {
        const response = await tasklistService.getAll();
        setTasksLists(response.data);
      } catch (err) {
        console.log("EROOOOOOOOOOOOOOOOOOORR!");
        console.error(err);
      }
    };
    fetchTaskLists();
  }, []);
  return (
    <div className='bg-gray-800'>
      {taskLists.length === 0 ? (<p>No task lists!</p>)
        : ( taskLists.map(taskList => (
          <div className="col-md-4 mb-3" key={taskList.id}>
            <div className="card">
              <div className="card-body">
                <h5 className="card-title">{taskList.title}</h5>
                <p className="card-text">{taskList.description}</p>
                {/* <Link to={`/taskList/${taskList.id}`} className="btn btn-info mr-2"> */}
                {/*   View Details */}
                {/* </Link> */}
              </div>
            </div>
          </div>
        ))
        )}
    </div>
  )
};
export default TaskLists;
