import {BrowserRouter, Route, Routes, Navigate} from 'react-router-dom'
import './DiagramApp.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import LoginComponent from './LoginComponent'
import LogoutComponent from './LogoutComponent'
import WelcomeComponent from './WelcomeComponent'
import ErrorComponent from './ErrorComponent'
import FooterComponent from "./FooterComponent"
import HeaderComponent from "./HeaderComponent"
import AuthProvider from './security/AuthContext'
import DiagramComponent from './DiagramComponent'
import { useAuth } from './security/AuthContext'

function AuthenticatedRoute({children}) {
    const authContext = useAuth()
    
    if (authContext.isAuthenticated) {
        return children
    }

    return <Navigate to="/"/>
}

export default function DiagramApp() {
    return (
        <div className="DiagramApp">
            <AuthProvider>
                <BrowserRouter>
                    <HeaderComponent />
                    <Routes>
                        <Route path='/' element={<LoginComponent/>}></Route>
                        <Route path='/login' element={<LoginComponent/>}></Route>
                        <Route path='/welcome/:username' element={
                            <AuthenticatedRoute>
                                 <WelcomeComponent/>
                            </AuthenticatedRoute>
                        } />
                        <Route path='/logout' element={
                             <AuthenticatedRoute>
                                <LogoutComponent/>
                             </AuthenticatedRoute>
                        } />
                        <Route path='/diagrams/:diagramId/nodes/:nodeId' element={
                             <DiagramComponent/>
                        } />
                        <Route path='*' element={<ErrorComponent/>}></Route>
                    </Routes>
                    {/* <FooterComponent /> */}
                </BrowserRouter>
            </AuthProvider>
        </div>
    )
}