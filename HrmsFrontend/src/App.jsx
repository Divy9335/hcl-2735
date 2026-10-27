import React, { useEffect, useState } from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './components/Home';
import Login from './components/Login';
import Registration from './components/Registration';
import Dashboard from './components/Dashboard';


const App = () => {

  const [Data, setData] = useState('');

  async function fetchData(){
    try{
      const url = "http://localhost:8080/";
      const data = await fetch(url);
      const parseData = await data.text();
      setData(parseData);
    }catch(e){
      console.log(e);
    }
  }

  useEffect(()=>{
    fetchData();
  },[])

  return (
    <div>

        <BrowserRouter>
          <Routes>
              <Route path='/' element={<Home/>} ></Route>
              <Route path='/login' element={<Login/>}></Route>
              <Route path='/register' element={<Registration/>}></Route>
              <Route path='/dashboard' element={<Dashboard/>}></Route>
          </Routes>
        </BrowserRouter>

    </div>
  )
}

export default App