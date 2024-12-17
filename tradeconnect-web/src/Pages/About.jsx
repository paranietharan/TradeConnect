import styles from './styles/About.module.css'
import TopNavigationBar from '../Components/utils/TopNavigationBar'
import ShoppingGirlsImg from '../assets/images/shopping_girls.jpg'
import DetailsBar from '../Components/About/DetailsBar';

function AboutPage() {
    return (
        <div className={styles.AboutPage}>
            <div className={styles.topNavigationBarContainer}>
                <TopNavigationBar />
            </div>
            <div className={styles.body}>
                <div className={styles.story}>
                    <div className={styles.text}>
                        <h1 className={styles.storyHeading}>Our Story</h1>
                        <p className={styles.storyBody}>Launced in 2015, Exclusive is South Asia’s
                            premier online shopping makterplace with an active presense in Bangladesh.
                            Supported by wide range of tailored marketing, data and service solutions,
                            Exclusive has 10,500 sallers and 300 brands and serves 3 millioons customers
                            across the region. </p>
                        <p className={styles.storyBody}>Exclusive has more than 1 Million products to offer,
                            growing at a very fast. Exclusive offers a diverse assotment in categories ranging  from consumer.</p>
                    </div>
                    <div className={styles.image}>
                        <img
                            src={ShoppingGirlsImg}
                            alt="Shopping girls"
                        />
                    </div>
                </div>

                <div className={styles.statistics}>
                    <DetailsBar />
                </div>
            </div>
        </div>
    )
}

export default AboutPage;