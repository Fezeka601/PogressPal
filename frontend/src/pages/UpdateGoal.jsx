function UpdateGoal() {

    return (

        <div className="form-page">

            <div className="form-card">

                <h1>Update Progress</h1>

                <form>

                    <label>

                        Current Value

                    </label>

                    <input
                        type="number"
                        placeholder="Current Progress"
                    />

                    <label>

                        Target Value

                    </label>

                    <input
                        type="number"
                        placeholder="Target Value"
                    />

                    <button>

                        Save Progress

                    </button>

                </form>

            </div>

        </div>

    );

}

export default UpdateGoal;