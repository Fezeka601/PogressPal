import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { register } from "../services/authService";

function Register() {

    const navigate = useNavigate();

    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");

    const [error, setError] = useState("");

   async function handleSubmit(e) {

        e.preventDefault();

        setError("");

        if (password !== confirmPassword) {

            setError("Passwords do not match.");

            return;

        }

        try {

            await register({
                username,
                email,
                password
            });

            alert("Registration successful!");

            navigate("/login");

        } catch (err) {

            setError("Registration failed.");

        }

    }

    return (

        <div className="form-page">

           <div className="auth-card">

                <h1>Create Account</h1>

                <form onSubmit={handleSubmit}>

                    <input
                        type="text"
                        placeholder="Username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        required
                    />

                    <input
                        type="email"
                        placeholder="Email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        required
                    />

                    <input
                        type="password"
                        placeholder="Password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />

                    <input
                        type="password"
                        placeholder="Confirm Password"
                        value={confirmPassword}
                        onChange={(e) => setConfirmPassword(e.target.value)}
                        required
                    />

                    <button type="submit">

                        Register

                    </button>

                </form>

                {error &&

                    <p style={{ color: "red", marginTop: "15px" }}>

                        {error}

                    </p>

                }

            </div>

        </div>

    );

}

export default Register;