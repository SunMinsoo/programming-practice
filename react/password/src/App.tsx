import { useState } from 'react';
import PasswordInput from './components/PasswordInput';
import ValidationList from './components/ValidationList';
import KisaResult from './components/KisaResult';
import { validatePassword } from './utils/passwordValidator';
import './App.css';

function App() {
  const [password, setPassword] = useState('');
  
  // 비밀번호가 변경될 때마다 자동으로 검증
  const validation = validatePassword(password);

  return (
    <div className="app-container">
      <h1 className="app-title">비밀번호 검증기</h1>

      <PasswordInput 
        value={password}
        onChange={setPassword}
      />

      <ValidationList rules={validation.rules} />
      <KisaResult 
        kisaValid={validation.kisaValid} 
        hasInvalidChars={validation.hasInvalidChars}
        password={password} 
      />

    </div>
  );
}

export default App;