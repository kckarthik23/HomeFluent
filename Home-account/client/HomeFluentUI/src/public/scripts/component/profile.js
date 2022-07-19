import React from "react";
import { ReactDOM } from "react";

class Profile extends React.Component
{
    constructor(props)
    {
        super(props);
        this.state={
User:[]
        }

    }
    componentDidMount()
    {
        this.renderUser(this.props.id)
    }
    render()
    {
        
        return(<div>

        </div>

        );
    }
}