import React from "react";
const Dashboard = () => {
    return (

        <div>
            <div className="App">
                <header >
                    <div>
                        <h2>User Dashboard</h2>
                    </div>
                </header>
            </div>
            <br />
            <div>
                <nav>
                    <a href="/logout">Logout</a>
                    <a href="/addFinance">Add your Finance</a>
                    <a href="/getUser">User profile</a>
                    <a href="/showFinance">My Finance</a>
                </nav>
            </div>
            <div>
                <span>
                   <h2>Welcome to HomeFluent Dashboard</h2> 
                </span>
            </div>

        </div>

    );
}
export { Dashboard };