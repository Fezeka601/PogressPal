import { Link } from "react-router-dom";

function GoalDetails() {

    return (

        <div className="goal-details">

            <div className="goal-header">

                <h1>Goal Details</h1>

                <Link to="/">
                    <button className="secondary-btn">
                        Back
                    </button>
                </Link>

            </div>

            <div className="goal-card-details">

                <h2>Goal Title</h2>

                <p>
                    <strong>Category:</strong> ____________
                </p>

                <p>
                    <strong>Description:</strong>
                </p>

                <div className="description-box">

                    Goal description will appear here.

                </div>

                <p>
                    <strong>Deadline:</strong> __ / __ / ____
                </p>

                <p>
                    <strong>Status:</strong> ____________
                </p>

                <p>
                    <strong>Progress</strong>
                </p>

                <div className="progress-bar">

                    <div className="progress-fill"></div>

                </div>

                <div className="goal-buttons">

                    <Link to="/update-goal">
                        <button className="primary-btn">
                            Update Progress
                        </button>
                    </Link>

                    <button className="edit-btn">
                        Edit Goal
                    </button>

                    <button className="delete-btn">
                        Delete Goal
                    </button>

                </div>

            </div>

        </div>

    );

}

export default GoalDetails;