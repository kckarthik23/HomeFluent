import  {Login} from "./component/login";
import { CreateUser} from "./component/createUser";
import * as ReactDOM from 'react-dom';
import React from "react";
import {
    BrowserRouter,
    Routes,
    Route,
  } from "react-router-dom";

console.log("hello");
const root=ReactDOM.createRoot(
    document.getElementById("root")
);

root.render(
    <BrowserRouter>
    <Routes>
        <Route  path="/" element={<Login/>}/>
        <Route exact path="*" element={<CreateUser/>}/>
        <Route
      path="*"
      element={
        <CreateUser/>
      }
    />
    </Routes>
    </BrowserRouter>
);