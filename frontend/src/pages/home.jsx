import { useNavigate } from 'react-router-dom';

function Home() {
  const navigate = useNavigate();
  return (
    <div className='flex flex-col items-center justify-center size-fit '>
      <h1 className='text-5xl'>Task List:</h1>
      <br></br>

      <button 
        onClick={() => navigate('/new-task-list')}
        className="text-2xl px-6 py-3 bg-indigo-600 text-white rounded-md hover:bg-indigo-700 "
      >
        Create New Task List
      </button>
    </div>
  );
}
export default Home;
