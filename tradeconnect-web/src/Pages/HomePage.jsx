import styles from './styles/HomePage.module.css';
import TopNavigationBar from '../Components/TopNavigationBar';
import NewArrivalAndCategory from '../Components/NewArrivalAndCategory';

function HomePage(){
    return(
        <div className={styles.HomePage}>
            <div className={styles.topNavigationBarContainer}>
                <TopNavigationBar />
            </div>
            <div className={styles.HomePageBody}>
                {/* Sale and New Arrival */}
                <div className={styles.newArrivalAndCategory}>
                    <NewArrivalAndCategory />
                </div>
                {/* Best Seller */}
                <div className={styles.bestSeller}></div>
                {/* Categories */}
                <div className={styles.categories}></div>
                {/* Brands */}
                <div className={styles.brands}></div>
                {/*Footer */}
                <div className={styles.footer}></div>
            </div>
        </div>
    );
}

export default HomePage;