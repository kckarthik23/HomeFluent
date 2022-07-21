import React from "react";
import { useLocation, Link } from "react-router-dom";
import UserService from "/Users/kcrao/ReactJS/HomeFluentUI/src/public/scripts/Services/UserService";

class Profile extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            User:null,
            Authorization: localStorage.getItem("Authorization")
        }
        this.renderUser = this.renderUser.bind(this);
    }
    componentDidMount() {
        this.renderUser(this.props.id)
    }
    renderUser(id) {
        let config = {
            headers: {
                Authorization: this.state.Authorization
            }
        }
        UserService.getUserById("25", config).then(res => {
            console.log("here"+res.data);
            this.setState({
User:res.data
            });
        }).catch(error => {
            console.log(error);
        });
    }
    render() {
        let {User}=this.state;
        console.log("after");
console.log(User);
        return (<div>
{User&&<h2>hello</h2>}
        </div>

        );
    }
}

export { Profile }; 