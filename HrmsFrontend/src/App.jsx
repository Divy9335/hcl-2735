import React from 'react'
import SampleComponent from './components/SampleComponent'
import{ useState } from 'react'


const App = () => {
  const employees = [
    { ename: "Aarav", eid: 101 },
    { ename: "Priya", eid: 102 },
    { ename: "Rahul", eid: 103 },
    { ename: "Ananya", eid: 104 },
    { ename: "Vikram", eid: 105 },
    { ename: "Sneha", eid: 106 },
    { ename: "Aditya", eid: 107 },
    { ename: "Neha", eid: 108 },
    { ename: "Rohan", eid: 109 },
    { ename: "Kavya", eid: 110 }
];
  return (
    <div className='grid grid-cols-3 gap-4 min-h-screen p-5 bg-lime-100'>
      {
        employees.map(emp=>{
          return <div className="box" key={emp.eid}>
            <SampleComponent ename={emp.ename} eid={emp.eid}></SampleComponent>
          </div>
        })
      }
    </div>
  )
}

export default App