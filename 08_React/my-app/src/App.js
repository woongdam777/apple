import './App.css';
// components 폴더의 Exam1.js를 가져와서 사용
// 사용할 때 이름을 Ex1으로 지정 
import Ex1 from './components/Exam1';
import Ex2 from './components/Exam2';
import PropsEx from './components/R01_props';
import State1 from './components/R02_state1';
import State2 from './components/R03_state2';
import State3 from './components/R04_state3';
import TodoList1 from './components/R05_todolist1';
import ComtextApi from './components/R06_context_api';

function App() {
  // 리액트 컴포넌트는 딱 하나의 요소만을 반환할 수 있다.
  // 여러 요소를 반환하고 싶을 때는 부모 요소로 묶어준다.
  return (
    // fragment(<></>) : 반환되는 요소를 감쌀 때 사용, 해석 x
    <>
      {/* jsx 주석 */}
      <h1>Hello React </h1>
      <div>리액트하는중</div>

      {/* <Ex1 /> */}
      {/* <Ex2 /> */}

      {/* <PropsEx name={ "홍길동" } /> */}
      {/* <PropsEx name={ "고길동" } /> */}
      {/* <PropsEx name={ "봉길동" } /> */}

      {/* <State1 /> */}
      {/* <State2 init={100} /> */}
      {/* <hr /> */}
      {/* <State3 /> */}

      {/* <TodoList1 /> */}
      <ComtextApi />

    </>

  );
}

export default App;