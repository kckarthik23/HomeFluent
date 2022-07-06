import React from "react";
import  userService from "/Users/kcrao/ReactJS/HomeFluentUI/src/public/scripts/Services/UserService";
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
            name: "eve",
            age: 18,
            totalIncome: 199999999999,
            occupation: "AGRI",
            qualification: "AGRI",
            password: "FGHDJ"
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
        }).catch(error => {
            alert(error);
        })
    }
    render() {
        return (<div>
            <form>
                <h2>Create your account</h2>
                <br />
                <input type={"text"} name={"name"} id="name" value={this.state.name} onChange={e => this.handleName} />Enter your Name
                <br /> <br />
                <input type={"number"} name={"age"} id="age" value={this.state.age} onChange={e => this.handleAge} />Enter your Age
                <br />  <br />
                <input type={"number"} name={"totalIncome"} id="totalIncome" value={this.state.totalIncome} onChange={e => this.handleTotalIncome} />Enter your total Income
                <br />
                <input type={"text"} name={"occupation"} id="occupation" value={this.state.occupation} onChange={e => this.hanldeOccupation} />Enter your Occupation
                <br />  <br />
                <input type={"text"} name={"qualification"} id="qualification" value={this.state.qualification} onChange={e => this.handleQualification} />Enter your Qualification
                <br /> <br />
                <input type={"password"} Occupation id="password" value={this.state.password} onChange={e => this.handlePassword} />Enter your Password
                <br /> <br />
                <button onClick={this.handleSubmit}>Submit</button>
            </form>
        </div>);

    }
}
export { CreateUser };