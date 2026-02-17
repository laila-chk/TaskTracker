import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { useState } from 'react'
import './App.css'
import NewTaskList from './pages/NewTaskList'
import Home from './pages/home.jsx'

function App() {
  const [count, setCount] = useState(0)

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/new-task-list" element={<NewTaskList/>} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
