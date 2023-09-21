import {BrowserRouter, Route, Routes, Navigate} from 'react-router-dom'
import './MapApp.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import LoginComponent from './LoginComponent'
import LogoutComponent from './LogoutComponent'
import WelcomeComponent from './WelcomeComponent'
import ErrorComponent from './ErrorComponent'
import FooterComponent from "./FooterComponent"
import HeaderComponent from "./HeaderComponent"
import AuthProvider from './security/AuthContext'
import MapComponent from './MapComponent'
import { useAuth } from './security/AuthContext'
import TopicComponent from './TopicComponent'
import TopicMapComponent from './TopicMapComponent'
import NodeComponent from './NodeComponent'

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
                        <Route path='/topics' element={
                             <AuthenticatedRoute>
                                <TopicComponent/>
                             </AuthenticatedRoute>
                        } />
                        <Route path='/topics/:topicId/maps' element={
                            <AuthenticatedRoute>
                                <TopicMapComponent/>
                            </AuthenticatedRoute>
                        } />
                        <Route path='/maps/:mapId' element={
                            <AuthenticatedRoute>
                                <MapComponent/>
                            </AuthenticatedRoute>
                        } />
                        <Route path='/nodes/:nodeId' element={
                            <AuthenticatedRoute>
                                <NodeComponent/>
                            </AuthenticatedRoute>
                        } />
                        <Route path='*' element={<ErrorComponent/>}></Route>
                    </Routes>
                    {/* <FooterComponent /> */}
                </BrowserRouter>
            </AuthProvider>
        </div>
    )
}