import React, { useState } from 'react'

const SampleComponent = (props) => {
    const [counter,setCounter] = useState(props.eid);
    function clickHandler(event){
        if(event.target.value === "plus"){
            setCounter(counter+1);
        }else{
            setCounter(counter-1);
        }
    }
  return (
    <div className='bg-green-400 rounded-2xl flex justify-center items-center flex-col text-2xl font-bold p-2'>
        <h1>{props.ename}</h1>
        <h2>{counter}</h2>
        <div className="button mt-10 flex gap-1.5">
            <button onClick={clickHandler} className='w-[50px] h-[50px] bg-green-800 rounded-md text-2xl font-bold text-white hover:bg-green-900' id='minus' value="minus">-</button>
            <button onClick={clickHandler } className='w-[50px] h-[50px] bg-green-800 rounded-md text-2xl font-bold text-white  hover:bg-green-900' id='plus' value="plus">+</button>
        </div>
        
    </div>
  )
}

export default SampleComponent