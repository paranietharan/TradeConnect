import React from 'react';
import styles from './styles/SignUpPage.module.css';
import TopNavigationBar from '../Components/TopNavigationBar';

function SignUpPage() {
  return (
    <div className={styles.signUpContainer}>
      <TopNavigationBar />
    </div>
  );
}

export default SignUpPage;