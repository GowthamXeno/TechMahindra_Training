import React from 'react'
import C3Component from './C3Component'
const C4Component = React.lazy(() => import('../../C4Component'));
const C5Component = React.lazy(() => import('../../C5Component'));

export default function C2Component() {
  return (
    <>
    <h1>C2Component</h1>
    <C3Component />
    <C4Component />
    <C5Component />
    </>
  )
}
 