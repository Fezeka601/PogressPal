import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { addGoal } from "../services/goalService";
import "./AddGoal.css";

function AddGoal() {

    const navigate = useNavigate();

    const [goal, setGoal] = useState({
        title: "",
        description: "",
        category: "",
        targetDate: "",
        targetValue: "",
        currentValue: 0,
        status: "NOT_STARTED"
    });

    const handleChange = (e) => {
        setGoal({
            ...goal,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = async (e) => {

        e.preventDefault();

        try {

            await addGoal(goal);

            alert("Goal created successfully!");

            navigate("/");

        } catch (error) {

            alert(error.message);

        }
    };

    return (

        <div className="form-page">

            <div className="form-card">

                <h1>Add a New Goal</h1>

                <p className="form-subtitle">
                    Set a goal and start tracking your progress.
                </p>

                <form onSubmit={handleSubmit}>

                    {/* Goal Title */}

                    <div className="form-group">

                        <label htmlFor="title">
                            Goal Title
                        </label>

                        <input
                            id="title"
                            type="text"
                            name="title"
                            placeholder="e.g. Learn Java"
                            value={goal.title}
                            onChange={handleChange}
                            required
                        />

                    </div>


                    {/* Description */}

                    <div className="form-group">

                        <label htmlFor="description">
                            Description
                        </label>

                        <textarea
                            id="description"
                            name="description"
                            placeholder="What do you want to achieve?"
                            rows="5"
                            value={goal.description}
                            onChange={handleChange}
                        />

                    </div>


                    {/* Category + Target Date */}

                    <div className="form-row">

                        <div className="form-group">

                            <label htmlFor="category">
                                Category
                            </label>

                            <select
                                id="category"
                                name="category"
                                value={goal.category}
                                onChange={handleChange}
                            >

                                <option value="">
                                    Select Category
                                </option>

                                <option value="EDUCATION">
                                    Education
                                </option>

                                <option value="HEALTH">
                                    Health
                                </option>

                                <option value="FINANCE">
                                    Finance
                                </option>

                                <option value="CAREER">
                                    Career
                                </option>

                                <option value="PERSONAL">
                                    Personal
                                </option>

                            </select>

                        </div>


                        <div className="form-group">

                            <label htmlFor="targetDate">
                                Target Date
                            </label>

                            <input
                                id="targetDate"
                                type="date"
                                name="targetDate"
                                value={goal.targetDate}
                                onChange={handleChange}
                            />

                        </div>

                    </div>


                    {/* Target Value + Current Value */}

                    <div className="form-row">

                        <div className="form-group">

                            <label htmlFor="targetValue">
                                Target Value
                            </label>

                            <input
                                id="targetValue"
                                type="number"
                                name="targetValue"
                                placeholder="e.g. 100"
                                value={goal.targetValue}
                                onChange={handleChange}
                            />

                        </div>


                        <div className="form-group">

                            <label htmlFor="currentValue">
                                Current Value
                            </label>

                            <input
                                id="currentValue"
                                type="number"
                                name="currentValue"
                                value={goal.currentValue}
                                onChange={handleChange}
                            />

                        </div>

                    </div>


                    {/* Save Goal */}

                    <button
                        type="submit"
                        className="save-goal-btn"
                    >
                        Save Goal
                    </button>

                </form>

            </div>

        </div>

    );
}

export default AddGoal;