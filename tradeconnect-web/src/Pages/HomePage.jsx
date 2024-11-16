import styles from './styles/HomePage.module.css';
import TopNavigationBar from '../Components/TopNavigationBar';
import NewArrivalAndCategory from '../Components/NewArrivalAndCategory';
import PageFooter from '../Components/PageFooter';
import SalesSection from '../Components/SalesSection';

function HomePage(){
    return(
        <div className={styles.HomePage}>
            <div className={styles.topNavigationBarContainer}>
                <TopNavigationBar />
            </div>
            <div className={styles.HomePageBody}>
                {/* Category and New Arrival */}
                <div className={styles.newArrivalAndCategory}>
                    <NewArrivalAndCategory />
                </div>
                {/* Sales */}
                <div className={styles.sales}>
                    <SalesSection />
                </div>
                {/* Categories */}
                <div className={styles.categories}></div>
                {/* Brands */}
                <div className={styles.brands}></div>
                {/*Footer */}
                <div className={styles.footer}>
                    <PageFooter />
                </div>
            </div>
        </div>
    );
}

export default HomePage;