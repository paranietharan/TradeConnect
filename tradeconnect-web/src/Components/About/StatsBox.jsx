 import styles from './styles/StatsBox.module.css'

 function StatsBox({icon, amount, text}){
    return(
        <div className={styles.StatsBoxContainer}>
            <div className={styles.icon}>
                <img
                src={icon}
                alt='icon'
                />
            </div>
            <div className={styles.amount}>
                <p>{amount}</p>
            </div>
            <div className={styles.text}>
                <p>{text}</p>
            </div>
        </div>
    )
 }

 export default StatsBox;