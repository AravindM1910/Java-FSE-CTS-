import CohortDetails from './components/CohortDetails';

function App() {
  return (
    <div>
      <CohortDetails name="React Bootcamp" status="ongoing" startDate="2025-08-01" />
      <CohortDetails name="NodeJS Mastery" status="completed" startDate="2025-05-10" />
    </div>
  );
}

export default App;
