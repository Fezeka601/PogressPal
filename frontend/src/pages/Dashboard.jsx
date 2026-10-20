import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { getGoals } from "../services/goalService";
import "./Dashboard.css";

function Dashboard() {

    const [goals, setGoals] = useState([]);

    useEffect(() => {
        loadGoals();
    }, []);

    async function loadGoals() {

        try {

            const data = await getGoals();

            setGoals(data);

        } catch (error) {

            console.error(error);

        }

    }

    return (

        <div className="dashboard">

            {/* Dashboard Header */}
            <div className="dashboard-header">

                <div>
                    <h1>Dashboard</h1>
                    <p>Track your goals and monitor your progress.</p>
                </div>

                <Link to="/add-goal" className="add-goal-link">
                    + Add Goal
                </Link>

            </div>


            {/* No Goals */}
            {goals.length === 0 ? (

                <div className="empty-state">

                    <h2>No Goals Yet</h2>

                    <p>
                        Create your first goal to begin.
                    </p>

                </div>

            ) : (

                /* Goal Cards */
                <div className="goal-grid">

                    {goals.map((goal) => {

                        const progress = goal.progressPercentage || 0;

                        return (

                            <div className="goal-card" key={goal.id}>

                                <h2>{goal.title}</h2>

                                <p className="goal-description">
                                    {goal.description}
                                </p>

                                <div className="goal-info">

                                    <p>
                                        <strong>Category:</strong>{" "}
                                        {goal.category}
                                    </p>

                                    <p>
                                        <strong>Status:</strong>{" "}
                                        {goal.status}
                                    </p>

                                    <p>
                                        <strong>Deadline:</strong>{" "}
                                        {goal.targetDate}
                                    </p>

                                </div>


                                {/* Progress */}
                                <div className="progress-section">

                                    <div className="progress-header">

                                        <strong>Progress</strong>

                                        <span>
                                            {progress.toFixed(0)}%
                                        </span>

                                    </div>

                                    <div className="progress-bar">

                                        <div
                                            className="progress-fill"
                                            style={{
                                                width: `${progress}%`
                                            }}
                                        ></div>

                                    </div>

                                </div>


                                {/* View Goal */}
                                <Link
                                    to={`/goal-details/${goal.id}`}
                                    className="view-goal-btn"
                                >
                                    View Goal
                                </Link>

                            </div>

                        );

                    })}

                </div>

            )}

        </div>

    );

}

export default Dashboard;