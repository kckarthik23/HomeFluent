import React from "react";
import userService from "/Users/kcrao/ReactJS/HomeFluentUI/src/public/scripts/Services/UserService";
import {Navigate} from "react-router-dom";
class CreateUser extends React.Component {

    constructor(props) {
        super(props);
        this.handleName = this.handleName.bind(this);
        this.handleAge = this.handleAge.bind(this);
        this.handleTotalIncome = this.handleTotalIncome.bind(this);
        this.hanldeOccupation = this.hanldeOccupation.bind(this);
        this.handleQualification = this.handleQualification.bind(this);
        this.handlePassword = this.handlePassword.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.state = {
            name: "",
            age: null,
            totalIncome: null,
            occupation: "",
            qualification: "",
            password: "",
            user:null,
            error:null
        };
    }

    handleName(e) {
        e.preventDefault();
        this.setState({
            name: e.target.value
        })
    }
    handleAge(e) {
        e.preventDefault();
        this.setState({
            age: e.target.value
        })
    }
    handleTotalIncome(e) {
        e.preventDefault();
        this.setState({
            totalIncome: e.target.value
        })
    }
    hanldeOccupation(e) {
        e.preventDefault();
        this.setState({
            occupation: e.target.value
        })
    }
    handleQualification(e) {
        e.preventDefault();
        this.setState({
            qualification: e.target.value
        })
    }
    handlePassword(e) {
        e.preventDefault();
        this.setState({
            password: e.target.value
        })
    }
    handleSubmit(e) {
        e.preventDefault();
        let userData = {
            "name": this.state.name,
            "age": this.state.age,
            "totalIncome": this.state.totalIncome,
            "occupation": this.state.occupation,
            "qualification": this.state.qualification,
            "password": this.state.password
        };
        userService.createUser(userData).then(res => {
            alert("user created successfully !!");
            this.setState({
                user:true
            });
        }).catch(error => {
            alert(error);
            this.setState({
                error:error
            });
        })
    }
    render() {
        let {user,error}=this.state;
        return (<div>
            {error&&alert("Data provided is invalid , please provide correct data")}
            {user&&(<Navigate to="/dashboard" replace={true}/>)}
            <form>
                <h2>Create your account</h2>
                <br />
                <input type={"text"} name={"name"} id="name" value={this.state.name} onChange={this.handleName} />Enter your Name
                <br /> <br />
                <input type={"number"} name={"age"} id="age" value={this.state.age} onChange={this.handleAge} />Enter your Age
                <br />  <br />
                <input type={"number"} name={"totalIncome"} id="totalIncome" value={this.state.totalIncome} onChange={this.handleTotalIncome} />Enter your total Income
                <br />  <br/>
                <input type={"text"} name={"occupation"} id="occupation" value={this.state.occupation} onChange={this.hanldeOccupation} />Enter your Occupation
                <br />  <br />
                <input type={"text"} name={"qualification"} id="qualification" value={this.state.qualification} onChange={this.handleQualification} />Enter your Qualification
                <br /> <br />
                <input type={"password"} Occupation id="password" value={this.state.password} onChange={this.handlePassword} />Enter your Password
                <br /> <br />
                <button onClick={this.handleSubmit}>Submit</button>
            </form>
        </div>);

    }
}
export { CreateUser };