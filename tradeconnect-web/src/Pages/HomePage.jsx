import styles from './styles/HomePage.module.css';
import TopNavigationBar from '../Components/utils/TopNavigationBar';
import NewArrivalAndCategory from '../Components/HomePage/NewArrivalAndCategory';
import PageFooter from '../Components/utils/PageFooter';
import SalesSection from '../Components/HomePage/SalesSection';
import CategorySection from '../Components/HomePage/CategorySection';
import PopularProducts from '../Components/HomePage/PopularProducts';
import ProductGrid from '../Components/HomePage/ProductGrid';

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

                {/* Popular Products */}
                <div className={styles.popularProducts}>
                    <PopularProducts />
                </div>

                {/* Categories */}
                <div className={styles.categories}>
                    <CategorySection />
                </div>

                <div className={styles.products}>
                    <ProductGrid />
                </div>
                {/*Footer */}
                <div className={styles.footer}>
                    <PageFooter />
                </div>
            </div>
        </div>
    );
}

export default HomePage;