import React from "react";
import userService from "/Users/kcrao/ReactJS/HomeFluentUI/src/public/scripts/Services/UserService";
import { Navigate } from "react-router-dom";
class Login extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            name: "",
            password: "",
            user: false,
            error: null

        }
        this.handleSubmit = this.handleSubmit.bind(this);
        this.onChangeName = this.onChangeName.bind(this);
        this.onChangePassword = this.onChangePassword.bind(this);
    }
    handleSubmit(e) {
        e.preventDefault();
        let user = {
            name: this.state.name,
            password: this.state.password
        }
        userService.sendLogin(user).then(res => {
            alert("user logged in successfully " + res.status);
            this.setState({
                user: true
            })
        }

        ).catch(e => {
            this.setState({
                name: "",
                password: "",
                error: e
            })
        });

    }
    onChangeName(e) {
        e.preventDefault();
        this.setState({
            name: e.target.value
        })
    }
    onChangePassword(e) {
        e.preventDefault();
        this.setState({
            password: e.target.value
        })
    }
    render() {
        let { user, error } = this.state;
        return (

            <div
            >
                <h2>Login</h2>
                {error && alert("invalid password please provide correct password")}
                {user && (<Navigate to="/dashboard" replace={true} />)}
                <form>
                    <input type={"text"} onChange={this.onChangeName} value={this.state.name} />Enter your Name
                    <br></br>
                    <input type={"password"} onChange={this.onChangePassword} value={this.state.password} />Enter your Password
                    <br></br>
                    <button onClick={this.handleSubmit}>Submit</button>
                    <br />
                    New User ? <a href="http://localhost:8000/createUser">create a New Account</a>
                </form>
            </div>);
    }
}

export { Login }