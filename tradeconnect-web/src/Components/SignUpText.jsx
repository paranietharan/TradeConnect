import React from "react";
import styles from "./styles/SignUpText.module.css";

function SignUpText() {
    return (
        <p className={styles.signUpText}>
            Don't have an account? <a className={styles.signUpLink} href="/signup">Sign up</a>
        </p>
    );
}

export default SignUpText;