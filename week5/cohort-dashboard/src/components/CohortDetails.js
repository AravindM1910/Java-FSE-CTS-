import styles from './CohortDetails.module.css';

const CohortDetails = ({ name, status, startDate }) => {
  const h3Style = {
    color: status === 'ongoing' ? 'green' : 'blue',
  };

  return (
    <div className={styles.box}>
      <h3 style={h3Style}>{name}</h3>
      <dl>
        <dt>Status:</dt>
        <dd>{status}</dd>
        <dt>Start Date:</dt>
        <dd>{startDate}</dd>
      </dl>
    </div>
  );
};

export default CohortDetails;
