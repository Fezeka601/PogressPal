import { BrowserRouter, Routes, Route } from "react-router-dom";

import Navbar from "./components/Navbar";
import GoalDetails from "./pages/GoalDetails";
import UpdateGoal from "./pages/UpdateGoal";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Dashboard from "./pages/Dashboard";
import AddGoal from "./pages/AddGoal";

import "./App.css";

function App() {
  return (
    <BrowserRouter>

      <Navbar />

      <div className="page-container">

        <Routes>

          <Route path="/" element={<Dashboard />} />

          <Route path="/login" element={<Login />} />

          <Route path="/register" element={<Register />} />

          <Route path="/add-goal" element={<AddGoal />} />
<Route path="/goal-details/:id" element={<GoalDetails />} />

<Route path="/update-goal" element={<UpdateGoal />} />
        </Routes>

      </div>

    </BrowserRouter>
  );
}

export default App;