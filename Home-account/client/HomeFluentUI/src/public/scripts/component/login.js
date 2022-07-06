import React from "react";


 class Login extends React.Component
{
    render()
    {
     return  (
             <div>
            <h2>Login</h2>
            <form>
                <input type={"text"}/>Enter your Name
                <br></br>
                <input type={"password"}/>Enter your Password
                <br></br>
                <button >Submit</button>
                <br/>
                New User ? <a href="http://localhost:8000/createUser">create a New Account</a>
            </form>
        </div>);
    }
}

export {Login}