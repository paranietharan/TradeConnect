import styles from './styles/HomePage.module.css';
import TopNavigationBar from '../Components/TopNavigationBar';

function HomePage(){
    return(
        <div className={styles.HomePage}>
            <div className={styles.topNavigationBarContainer}>
                <TopNavigationBar />
            </div>
        </div>
    );
}

export default HomePage;