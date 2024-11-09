import { Link } from 'react-router-dom';
import styles from './styles/SignUpForm.module.css';

/**
 * SignUpForm component
 * 
 * It is used in Signup page
*/
function SignUpForm() {
    return (
        <div className={styles.SignUpFormContainer}>
            <div className={styles.headingtext}>Create an Account</div>
            <div className={styles.detailsText}>Enter your details below to create your account</div>

            <div className={styles.inputContainer}>
                <form>
                    <input type="text" id="name" name="name" placeholder="Enter your name" />

                    <input type="email" id="email" name="email" placeholder="Enter your email" />

                    <input type="password" id="password" name="password" placeholder="Enter your password" />

                    <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm your password" />

                    <button type="submit" className={styles.signUpButton}>Sign Up</button>

                    <div className={styles.alreadyHaveAccountText}>Already have an account? <Link to="\">Login</Link></div>
                </form>

            </div>

        </div>
    );
}

export default SignUpForm;