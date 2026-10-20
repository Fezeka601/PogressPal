import GoalCard from "./GoalCard";

function GoalList({ goals }) {
  return (
    <div className="goal-grid">

      {goals.map((goal) => (
        <GoalCard
          key={goal.id}
          goal={goal}
        />
      ))}

    </div>
  );
}

export default GoalList;