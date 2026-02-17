import React, { useState } from 'react';

function NewTaskList() {
  const [value, setValue] = useState('');
  const [desc, setDesc] = useState('');
  
  const handleChange = (event) => {
    setValue(event.target.value);
  };

  const handleDescChange = (event) => {
    setDesc(event.target.desc);
  };

  return (
    <div className='flex flex-col items-center justify-center size-fit '>
        <h1 className="text-5xl ">Create List of tasks</h1>
      <div className="grid bg-gray-800 rounded-md place-items-start w-full m-3">
        <h5 className='mx-2 text-gray-400 text-xl'>Title:</h5>
        <input className='mx-1 my-2 w-full focus:outline-none text-3xl'
          type="text"
          id="TaskListName"
          value={value} 
          onChange={handleChange} 
        />
      </div>
      <div className="grid bg-gray-800 rounded-md place-items-start w-full m-3">
        <h5 className='mx-2 text-gray-400 text-xl'>Description:</h5>
        <textarea rows="" cols="" className='mx-1 my-2 w-full focus:outline-none text-3xl
          resize-none'
          id="TaskListDescription"
          value={desc} 
          onChange={handleDescChange} 
        >
        </textarea>
      </div>

      <button 
        onClick={() => navigate('/')}
        className="text-2xl px-6 py-3 bg-gray-900 text-white rounded-md hover:bg-gray-700 w-full"
      >
        Create New Task List
      </button>

    </div>
  );
}
export default NewTaskList;
