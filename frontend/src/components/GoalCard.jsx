import ProgressBar from "./ProgressBar";

function GoalCard({ goal }) {
  return (
    <div className="goal-card">

      <h3>{goal.title}</h3>

      <p><strong>Category:</strong> {goal.category}</p>

      <p><strong>Deadline:</strong> {goal.deadline}</p>

      <ProgressBar progress={goal.progress} />

      <p>{goal.progress}% Complete</p>

      <span className="status">{goal.status}</span>

    </div>
  );
}

export default GoalCard;