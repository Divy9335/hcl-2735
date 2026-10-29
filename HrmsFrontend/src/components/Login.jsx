import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

const Login = () => {
    const [loginForm, setLoginForm] = useState({empid:'',password:''})
    const navigate = useNavigate();
    function changeHandler(event){
        setLoginForm(prevData=>{
        return {
            ...prevData,
            [event.target.name] : event.target.type === "checkbox" ? event.target.checked : event.target.value,
        }
        })
        
    }

    async function submitHandler(e) {
    e.preventDefault();

    try {
        const params = new URLSearchParams({
            empid: loginForm.empid,
            password: loginForm.password
        });

        const server = await fetch(
            "http://localhost:8080/v1/user/login",
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded"
                },
                body: params.toString()
            }
        );

        const responseText = await server.text();
        console.log(responseText);

        if (!server.ok) {
            alert(`Error ${server.status}: ${responseText}`);
            return;
        }

        if (responseText.trim() === "Employee is Logged in") {
            navigate("/", {
                state: { empid: loginForm.empid }
            });
        } else {
            alert("Invalid employee ID or password");
        }

    } catch (error) {
        console.error("Login error:", error);
        alert("Unable to connect to the server.");
    }
}


  return (
    <section className="bg-gray-50 dark:bg-gray-900">
    <div className="flex flex-col items-center justify-center px-6 py-8 mx-auto min-h-screen lg:py-0">
        
        <div className="w-full bg-white rounded-lg shadow dark:border md:mt-0 sm:max-w-md xl:p-0 dark:bg-gray-800 dark:border-gray-700">
            <div className="p-6 space-y-4 md:space-y-6 sm:p-8">
                <h1 className="text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl dark:text-white">
                    Sign in to your account
                </h1>
                <form className="space-y-4 md:space-y-6" onSubmit={submitHandler}>
                    <div>
                        <label htmlFor="empid" className="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Your Employee id</label>
                        <input type="number" value={loginForm.empid} onChange={changeHandler} name="empid" id="empid" className="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="ex. 12345" required=""/>
                    </div>
                    <div>
                        <label htmlFor="password" className="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Password</label>
                        <input type="password" value={loginForm.password} onChange={changeHandler} name="password" id="password" placeholder="••••••••" className="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required=""/>
                    </div>
                    <div className="flex items-center justify-between">
                        <div className="flex items-start">
                            <div className="flex items-center h-5">
                                <input id="remember" aria-describedby="remember" type="checkbox" className="w-4 h-4 border border-gray-300 rounded bg-gray-50 focus:ring-3 focus:ring-primary-300 dark:bg-gray-700 dark:border-gray-600 dark:focus:ring-primary-600 dark:ring-offset-gray-800" required=""/>
                            </div>
                            <div className="ml-3 text-sm">
                                <label htmlFor="remember" className="text-gray-500 dark:text-gray-300">Remember me</label>
                            </div>
                        </div>
                        <a href="#" className="text-sm text-white font-medium text-primary-600 hover:underline dark:text-primary-500">Forgot password?</a>
                    </div>
                    <button type="submit" className="w-full text-white bg-primary-600 hover:bg-primary-700 focus:ring-4 focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800">Sign in</button>
                    <p className="text-sm font-light text-gray-500 dark:text-gray-400">
                        Don’t have an account yet? <a href="/register" className="font-medium text-primary-600 hover:underline dark:text-primary-500">Sign up</a>
                    </p>
                </form>
            </div>
        </div>
    </div>
    </section>
  )
}

export default Login;