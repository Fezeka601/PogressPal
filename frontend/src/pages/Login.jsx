import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { login } from "../services/authService";

function Login() {

    const navigate = useNavigate();

    const [username, setUsername] = useState("");

    const [password, setPassword] = useState("");

    const [error, setError] = useState("");

    async function handleSubmit(e) {

        e.preventDefault();

        try {

            await login(username, password);

            navigate("/");

        } catch (err) {

            setError("Invalid username or password");

        }

    }

    return (

        <div className="form-page">

           <div className="auth-card">

                <h1>Login</h1>

                <p>Welcome back to ProgressPal</p>

                {error && (

                    <p style={{color:"red"}}>

                        {error}

                    </p>

                )}

                <form onSubmit={handleSubmit}>

                    <input
                        type="text"
                        placeholder="Username"
                        value={username}
                        onChange={(e)=>setUsername(e.target.value)}
                        required
                    />

                    <input
                        type="password"
                        placeholder="Password"
                        value={password}
                        onChange={(e)=>setPassword(e.target.value)}
                        required
                    />

                    <button type="submit">

                        Login

                    </button>

                </form>

                <p>

                    Don't have an account?

                </p>

              <Link to="/register">

                    Register

                </Link>

            </div>

        </div>

    );

}
export default Login;