import API_URL from "../api/api";

/*
 * Get all goals for the logged-in user
 */
export async function getGoals() {

    const response = await fetch(`${API_URL}/api/goals`, {
        method: "GET",
        credentials: "include"
    });

    if (!response.ok) {
        throw new Error("Failed to load goals");
    }

    return await response.json();
}

/*
 * Get one goal by ID
 */
export async function getGoal(id) {

    const response = await fetch(`${API_URL}/api/goals/${id}`, {
        method: "GET",
        credentials: "include"
    });

    if (!response.ok) {
        throw new Error("Goal not found");
    }

    return await response.json();
}

/*
 * Create a new goal
 */
export async function addGoal(goal) {

    const response = await fetch(`${API_URL}/api/goals`, {
        method: "POST",
        credentials: "include",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(goal)
    });

    if (!response.ok) {
        throw new Error("Failed to create goal");
    }

    return await response.json();
}

/*
 * Update a goal
 */
export async function updateGoal(id, goal) {

    const response = await fetch(`${API_URL}/api/goals/${id}`, {
        method: "PUT",
        credentials: "include",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(goal)
    });

    if (!response.ok) {
        throw new Error("Failed to update goal");
    }

    return await response.json();
}

/*
 * Update progress
 */
export async function updateProgress(id, progress) {

    const response = await fetch(
        `${API_URL}/api/goals/${id}/progress?progress=${progress}`,
        {
            method: "PATCH",
            credentials: "include"
        }
    );

    if (!response.ok) {
        throw new Error("Failed to update progress");
    }

    return await response.json();
}

/*
 * Delete a goal
 */
export async function deleteGoal(id) {

    const response = await fetch(`${API_URL}/api/goals/${id}`, {
        method: "DELETE",
        credentials: "include"
    });

    if (!response.ok) {
        throw new Error("Failed to delete goal");
    }

    return true;
}