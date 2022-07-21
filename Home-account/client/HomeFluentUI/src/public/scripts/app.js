import { Login } from "./component/login";
import { CreateUser } from "./component/createUser";
import { Dashboard } from "./component/dashBoard";
import * as ReactDOM from 'react-dom';

import React from "react";
import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";
import { Logout } from "./component/logout";
import { Profile } from "./component/profile";
import { Finance } from "./component/finance";
import {AddFinance} from "./component/addfinance";

console.log("hello");
const root = ReactDOM.createRoot(
  document.getElementById("root")
);

root.render(
  <BrowserRouter>
    <Routes>
      <Route exact path="/" element={<Login />} />
      <Route exact path="createUser" element={<CreateUser />} />
      <Route exact path="dashboard" element={<Dashboard/>} />
      <Route path="logout" element={<Logout />} />
      <Route path="addFinance" element={<AddFinance />} />
      <Route path="getUser" element={<Profile />} />
      <Route path="showFinance" element={<Finance />} />
      <Route
        path="*"
        element={
          <h2>Please enter the correct url</h2>
        }
      />
    </Routes>
  </BrowserRouter>
);