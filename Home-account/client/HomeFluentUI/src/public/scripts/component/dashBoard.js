import React from "react";
import { useLocation, Link } from "react-router-dom";

const Dashboard = (props) => {
    let location = useLocation();
    //console.log(location.state.userId);
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
                    <Link to="logout" state={{ userId: location.state.userId }}>Logout</Link>
                    <Link to="/addFinance" state={{ userId: location.state.userId }}>Add your Finance</Link>
                    <Link to="/getUser" state={{ userId: location.state.userId }}>User profile</Link>
                    <Link to="/showFinance" state={{ userId: location.state.userId }}>My Finance</Link>
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